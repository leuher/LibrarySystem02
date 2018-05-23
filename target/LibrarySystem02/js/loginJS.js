function login_data(){
    var username = document.getElementById("username");
    var password = document.getElementById("password");

    var data = {};
    data["username"] = username.value;
    data["password"] = password.value;

    return data;
}

function login_submit(){
    var data = login_data();

    $.ajax({
        url:"loginUser",
        type:"POST",
        data:data,
        dataType:"JSON",
        success:function (result) {
            if(result == true){
                alert("登录成功,立刻跳转管理页面!");
                setTimeout('window.location.href="indexpage.html"');
            }else{
                alert("用户名或密码错误!");
            }
        },
        error:function () {
            alert("请求错误!");
        }
    });
}