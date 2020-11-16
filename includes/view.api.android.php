<?php

include_once 'dbh.inc.php';

class View_api_android_class extends Database{

    public function __construct(){
        $this->db_connection();
    }

  
    public function select_all_users(){
        
  
    $query="Select * from tbl_android_users;";
    $result=mysqli_query($this->connection,$query);
     return $result;
  

        
    
        

    }

     

  
}


?>