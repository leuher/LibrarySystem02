function register_data(){
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var repassword = document.getElementById("repassword");
    var email = document.getElementById("email");

    if(password.value != repassword.value){
        alert("两次密码不一致!");
        return;
    }

    if(username.value == ""){
        alert("用户名不能为空!");
        return;
    }

    var data = {};
    data["username"] = username.value;
    data["password"] = password.value;
    data["email"] = email.value;

    return data;
}

function register_submit() {
    var data = register_data();

    $.ajax({
        url:"insertUser",
        type:"POST",
        data:data,
        dataType:"JSON",
        success:function (result) {
            console.log(result);
            if(result == true){
                alert("注册成功,3秒后跳转登录页面!");
                setTimeout('window.location.href=login.html');
            }else{
                alert("用户名已存在,请重新输入!");
            }
        },
        errorL:function () {
            alert("请求失败!");
        }
    });
}