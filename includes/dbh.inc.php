<?php 
class Database{
public $dbhost;
public $dbusername;
public $dbpass;
public $dbname;

protected function db_connection(){

$this->dbhost="localhost";
$this->dbusername="root";
$this->dbpass="";
$this->dbname="android_crud_mysql";

$this->connection = new mysqli($this->dbhost,$this->dbusername,$this->dbpass,$this->dbname);
 return $this->connection;


}

}

?>