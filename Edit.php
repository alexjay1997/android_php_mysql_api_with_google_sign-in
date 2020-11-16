<?php
include 'includes/view.class.php';

$conn_select_edit_user = new View_class();
$user_id =$_GET['id'];
$select_user_to_edit = $conn_select_edit_user->select_user_edit($user_id);
$row=mysqli_fetch_array($select_user_to_edit);

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit page</title>
</head>
<body>
<div class="form-register">
            <h2>Edit user info</h2><br/>
            <form method="post" action="functions/update.php?id=<?php echo $user_id;?>">
                <input type="text" name="fullname" value="<?php echo $row['fullname'];?>"><br/><br/>
                <input type="text" name="username" value="<?php echo $row['username'];?>"><br/><br/>
                <input type="password" name="password" value="<?php echo $row['password'];?>"><br/><br/>
                <input type="submit" value="Update" name="update-btn">

        </form>
    </div>
</body>
</html>