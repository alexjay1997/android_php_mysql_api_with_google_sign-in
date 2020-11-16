<?php
include 'includes/view.class.php';

$conn_select_all_users = new View_class();

$read_all_user = $conn_select_all_users->select_all_users();

$number = mysqli_num_rows($read_all_user);



?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crud_app</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <style>
    .mychart-container{
        
        width:600px;
        height:auto;
        margin:0 auto;
        }
        table{
            border-collapse:collapse;
            background:#white;
            box-shadow: 2px 1px 10px 2px #eee;
        }
        td,th{
            border:1px solid #ccc;
            padding:12px;
        }

    </style>
</head>
<body>
    <div class="form-register">
            <h2>Register</h2><br/>
            <form method="post" action="functions/create.php">
                <input type="text" name="fullname" placeholder="Name"><br/><br/>
               <input type="text" name="username" placeholder="Username"><br/><br/>
                <input type="password" name="password" placeholder="Password"><br/><br/>
                 <input type="submit" value="Submit" name="reg-btn">

        </form>
    </div>


    
      
  
    <div class="table-container">
           <table>
               <tr>
                   <th>
                        UserID
                   </th>
                   <th>
                       Name
                   </th>
                   <th>
                        UserName
                   </th>
                   <th>
                        Password
                   </th>
                   <th>
                        Action
                   </th>
             
               
               </tr>
                <?php
                
                    // $data = array();
                foreach($read_all_user as $row)
                {
                    $data[] = $row;
        
                ?>
                   
              
                  
               <tr>

                    <td>
                        <?php echo $row['id'];?>
                    </td> 
                    <td>
                        <?php echo $row['fullname'];?>
                    </td>               
                                
                    <td>
                        <?php echo $row['username'];?>
                    </td> 

                    <td>
                        <?php echo $row['password'];?>
                    </td> 
                    
                   
                             
                    <td><a href="Edit.php?id=<?php echo $row['id'];?>">Edit</a>&nbsp;
                   <a href="delete.php?id=<?php echo $row['id'];?>">Delete</a></td>
                
                    
               </tr>
               <p id="demo"></p>
               <?php
                 
              
         
                }
                   ?>   
             
           </table>
           
    </div>







</body>
</html>