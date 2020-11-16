<?php

include_once 'dbh.inc.php';

class View_class extends Database{

    public function __construct(){
        $this->db_connection();
    }

    public function select_all_users(){

    $query="Select * from tbl_android_users";
    $result=mysqli_query($this->connection,$query);
        return $result;



    }

   
  

    public function select_user_edit($user_id){

        $query="Select * from tbl_android_users where id ='$user_id'";
        $result=mysqli_query($this->connection,$query);
            return $result;
        }

        public function check_user($username){

            $query="Select * from tbl_android_users where username ='$username'";
            $result=mysqli_query($this->connection,$query);
                return $result;
            }
  
}
?>