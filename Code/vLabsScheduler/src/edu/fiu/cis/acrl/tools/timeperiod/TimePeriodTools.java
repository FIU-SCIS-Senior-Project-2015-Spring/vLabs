package edu.fiu.cis.acrl.tools.timeperiod;

import java.util.ArrayList;
import java.util.Calendar;

import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;

public class TimePeriodTools {

	// Debug level for this class
	private static int DEBUG_LEVEL = 4;
	
	static public ArrayList<TimePeriod> convertFromEventToTimePeriod(
			ArrayList<ScheduledEvent> eventList) {
		
		if (eventList == null) 
			return null;
		
		ArrayList<TimePeriod> timePeriodList = new ArrayList<TimePeriod>();
		
		for (int i=0; i<eventList.size(); i++) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(eventList.get(i).getTimePeriod().getStartTime());
			timePeriod.setEndTime(eventList.get(i).getTimePeriod().getEndTime());
			timePeriodList.add(timePeriod);
			
		}
		
		return timePeriodList;
		
	}
	
	static public boolean overlap(
			Calendar firstStartTime,
			Calendar firstEndTime,
			Calendar secondStartTime,
			Calendar secondEndTime) {
	
		boolean retVal = false;
		
		if (   ((firstStartTime.compareTo(secondStartTime) >= 0) &&
				(firstStartTime.compareTo(secondEndTime) < 0)) ||
			   ((firstEndTime.compareTo(secondStartTime) > 0) &&
				(firstEndTime.compareTo(secondEndTime) <= 0)) ||
			   ((firstStartTime.compareTo(secondStartTime) <= 0) &&
				(firstEndTime.compareTo(secondEndTime) >= 0)))
			retVal = true;
				
		return retVal;
		
	}
	
	static public boolean overlap(
			Calendar startTime,
			Calendar endTime,
			ArrayList<TimePeriod> periodList) {
		
		boolean retVal = false;
		
		if (periodList != null) {
			
			for (int i=0; i<periodList.size(); i++)
				if (overlap(
						startTime,
						endTime,
						periodList.get(i).getStartTime(),
						periodList.get(i).getEndTime())) {
					
					retVal = true;
					break;
					
				}
			
		}
			
		return retVal;
	}
	
	static public ArrayList<TimePeriod> fixAndSortTimePeriodList(
			ArrayList<TimePeriod> timePeriodList) {
		
		if (timePeriodList == null)
			return null;
		
		if (timePeriodList.size() <= 1) 
			return timePeriodList;
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - fixAndSortTimePeriodList] " +
				"timePeriodList.size(): " + timePeriodList.size());

		ArrayList<TimePeriod> fixedList = 
			getCommonTimePeriods(
					timePeriodList,
					timePeriodList);

		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - fixAndSortTimePeriodList] " +
				"fixedList.size(): " + fixedList.size());

		return fixedList;
		
	}
	
	static public ArrayList<TimePeriod> fixAndSortTimePeriodList(
			ArrayList<TimePeriod> timePeriodList,
			Calendar startTime,
			Calendar endTime) {
		
		if (timePeriodList == null)
			return null;
		
		if (timePeriodList.size() <= 1) 
			return timePeriodList;
		
		ArrayList<TimePeriod> fixedList = fixAndSortTimePeriodList(timePeriodList);

		while (fixedList.get(0).getEndTime().compareTo(startTime) <= 0)
			fixedList.remove(0);
		
		if (fixedList.get(0).getStartTime().compareTo(startTime) < 0)
			fixedList.get(0).setStartTime(startTime);
			
		while (fixedList.get(fixedList.size()-1).getStartTime().compareTo(endTime) >= 0)
			fixedList.remove(fixedList.size()-1);
		
		if (fixedList.get(fixedList.size()-1).getEndTime().compareTo(endTime) > 0)
			fixedList.get(fixedList.size()-1).setEndTime(endTime);
			
		return fixedList;
		
	}
	
	static public ArrayList<TimePeriod> getCommonTimePeriods(
			ArrayList<TimePeriod> timePeriodList1,
			ArrayList<TimePeriod> timePeriodList2) {
		
		if ((timePeriodList1 == null) || (timePeriodList2 == null))
			return null;
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - getCommonTimePeriods] " +
				"list1 size: " + timePeriodList1.size());
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - getCommonTimePeriods] " +
				"list2 size: " + timePeriodList2.size());
				
		ArrayList<TimePeriod> commonPeriods = new ArrayList<TimePeriod>();
		
		ArrayList<TimePeriod> allPeriods = new ArrayList<TimePeriod>();
		allPeriods.addAll(timePeriodList1);
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - getCommonTimePeriods] " +
				"allPeriods size: " + allPeriods.size());
		allPeriods.addAll(timePeriodList2);
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - getCommonTimePeriods] " +
				"allPeriods size: " + allPeriods.size());
		
		ArrayList<TimePeriodWithCounter> countedList = countPeriods(allPeriods);
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - getCommonTimePeriods - " +
				"after countPeriods] countedList size: " + countedList.size());
		for (int i = 0; i < countedList.size(); i++) {
			
			if (countedList.get(i).getCounter() >= 2) {
				
				TimePeriod timePeriod = new TimePeriod();
				timePeriod.setStartTime(countedList.get(i).getStartTime());
				timePeriod.setEndTime(countedList.get(i).getEndTime());
				
				commonPeriods.add(timePeriod);
						
			}
		}
		
		commonPeriods = shortenTimePeriodList(commonPeriods);
		
		return commonPeriods;
	
	}

	/**
	 * 
	 * @param longList
	 * @return
	 */
	static public ArrayList<TimePeriod> shortenTimePeriodList(
			ArrayList<TimePeriod> longList) {
	
		if (longList == null) 
			return null;
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - shortenTimePeriodList] Inside!");
				
		ArrayList<TimePeriod> shortList = new ArrayList<TimePeriod>();
		
		if (longList == null) 
			return shortList;
		
		if (longList.size() == 0)
			return shortList;
		
		int i = 0;
		int j = 0;
		shortList.add(longList.get(i));
		if (longList.size() > 1) {
		
			i++;
			while (i < longList.size()) {
				
				if (shortList.get(j).getEndTime().compareTo(longList.get(i).getStartTime()) == 0) {
					
					shortList.get(j).setEndTime(longList.get(i).getEndTime());
					i++;
					
				}
				else {
					
					shortList.add(longList.get(i));
					i++;
					j++;
					
				}

			}
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - shortenTimePeriodList] Ready to get out!");
		
		return shortList;
	}

	static public ArrayList<TimePeriod> toggleTimePeriodList(
			ArrayList<TimePeriod> sortedList, Calendar startTime, Calendar endTime) {

		if (sortedList == null)
			return null;
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - toggleTimePeriodList] " +
				"sortedList size: " + sortedList.size() + " " +
				"startTime: " + startTime.getTime() + " " +
				"endTime: " + endTime.getTime());
		
		ArrayList<TimePeriod> toggledList = new ArrayList<TimePeriod>();
		
		if (startTime.compareTo(endTime) >= 0)
			return toggledList;
		
		if (sortedList.size() == 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(endTime);
			
			toggledList.add(timePeriod);
			return toggledList;
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - toggleTimePeriodList] " +
				"firstTime: " + sortedList.get(0).getStartTime().getTime() +
				"lastTime: " + sortedList.get(sortedList.size()-1).getEndTime().getTime());
		
		if ((startTime.compareTo(sortedList.get(sortedList.size()-1).getEndTime()) >= 0) ||
			(endTime.compareTo(sortedList.get(0).getStartTime()) <= 0)) {
				
				TimePeriod timePeriod = new TimePeriod();
				timePeriod.setStartTime(startTime);
				timePeriod.setEndTime(endTime);
				
				toggledList.add(timePeriod);
				return toggledList;
					
		}

		if (sortedList.size() == 1) {
			
			if ((startTime.compareTo(sortedList.get(0).getStartTime()) == 0) &&
				(endTime.compareTo(sortedList.get(0).getEndTime()) == 0)) {
						
						return toggledList;
							
			}
			
		}
		
		if (startTime.compareTo(sortedList.get(0).getStartTime()) < 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(startTime);
			timePeriod.setEndTime(sortedList.get(0).getStartTime());
			
			toggledList.add(timePeriod);
		
		}
		
		for (int i = 0; i < sortedList.size()-1; i++) {
			
			if (sortedList.get(i).getEndTime().compareTo(sortedList.get(i+1).getStartTime()) < 0) {
				
				TimePeriod timePeriod = new TimePeriod();
				timePeriod.setStartTime(sortedList.get(i).getEndTime());
				timePeriod.setEndTime(sortedList.get(i+1).getStartTime());
				
				toggledList.add(timePeriod);
			
				}
		}

		if (endTime.compareTo(sortedList.get(sortedList.size()-1).getEndTime()) > 0) {
			
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStartTime(sortedList.get(sortedList.size()-1).getEndTime());
			timePeriod.setEndTime(endTime);
			
			toggledList.add(timePeriod);
		
		}
		
		toggledList = shortenTimePeriodList(toggledList);
		
		return toggledList;
		
	}

	public static ArrayList<TimePeriodWithCounter> countPeriods(
			ArrayList<TimePeriod> timePeriodList) {
		
		if (timePeriodList == null)
			return null;
		
		ArrayList<TimePeriodWithCounter> countedList = new ArrayList<TimePeriodWithCounter>();
		
		ArrayList<Calendar> sortedCalendarList= new ArrayList<Calendar>();
		for (int i = 0; i < timePeriodList.size(); i++) {
			
			sortedCalendarList = insertCalendar(sortedCalendarList, timePeriodList.get(i).getStartTime());
			sortedCalendarList = insertCalendar(sortedCalendarList, timePeriodList.get(i).getEndTime());
			
		}
			
		for (int i = 1; i < sortedCalendarList.size(); i++) {
		
			TimePeriodWithCounter period = new TimePeriodWithCounter();
			period.setStartTime(sortedCalendarList.get(i-1));
			period.setEndTime(sortedCalendarList.get(i));
			period.setCounter(0);
			
			countedList.add(period);
			
		}
		
		for (int i = 0; i < timePeriodList.size(); i++) {
		
			TimePeriod timePeriod = timePeriodList.get(i);
			// int start = sortedCalendarList.indexOf(timePeriod.getStartTime());
			// int end = sortedCalendarList.indexOf(timePeriod.getEndTime());
			int start = getIndexOf(sortedCalendarList, timePeriod.getStartTime());
			int end   = getIndexOf(sortedCalendarList, timePeriod.getEndTime  ());
			
			DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - countPeriods] start index: " + start);
			DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - countPeriods] end index: " + end);

			for (int j = start; j < end; j++) {
				
				countedList.get(j).incCounter();
				
			}
			
		}
		
		for (int i = 0; i < countedList.size(); i++) {
			
			DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - countPeriods] " +
					"start: " + countedList.get(i).getStartTime().getTime() + " - " +		
					"counter[" + i + "]: " + countedList.get(i).getCounter());
			
		}
		
		return countedList;
	
	}

	private static int getIndexOf(ArrayList<Calendar> sortedCalendarList,
			Calendar time) {
		
		int retVal = -1;
		if ((sortedCalendarList != null) && (time != null)) {
			long longTime = time.getTime().getTime();
			for (int i=0; i<sortedCalendarList.size(); i++) {
				if (sortedCalendarList.get(i).getTime().getTime() == longTime) {
					retVal = i;
					break;
				}
			}
		}
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - getIndexOf] " +
				"index is: " + retVal);
		
		return retVal;
	}

	private static ArrayList<Calendar> insertCalendar(
			ArrayList<Calendar> sortedList, Calendar time) {
	
		if (sortedList == null)
			return null;
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - insertCalendar] time: " + time.getTime() + " " +
				"sortedList size: " + sortedList.size());
		
		ArrayList<Calendar> retList = sortedList;
		if (sortedList.size() == 0) {
			retList.add(time);
			DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - insertCalendar] " +
					"retList size: " + retList.size());
			
			return retList;
		}
		
		int index = 0;
		while (index < sortedList.size()) {
			
			if (sortedList.get(index).compareTo(time) == 0) {
				
				DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - insertCalendar] " +
						"time already exists! retList size: " + retList.size());
				return retList;
				
			}
				
			if (sortedList.get(index).compareTo(time) > 0) 
				break;
				
			index++;
			
		}
		retList.add(index, time);
		
		DebugTools.println(DEBUG_LEVEL, "[TimePeriodTools - insertCalendar] " +
				"inserted at: " + index + " retList size: " + retList.size());
	
		return retList;
	}

}
