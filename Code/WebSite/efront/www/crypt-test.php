<?
	// phpinfo();
        echo dirname(dirname(__FILE__)) . "/libraries/includes/crypt.php" ;
        require_once(dirname(dirname(__FILE__)) . "/libraries/includes/crypt.php");
	$password = "Masoud";
	echo "<br />\$password: $password";
	$encrypted_password = Crypt::encrypt($password);
	echo "<br />\$encrypted_password: $encrypted_password";
	$decrypted_password = Crypt::decrypt($encrypted_password);;
	echo "<br />\$decrypted_password: $decrypted_password";
?>
