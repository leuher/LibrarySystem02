function online() {
    $.ajax({
        url: "online",
        type: "GET",
        success: function (result) {
            if (result != null) {
                $("#username").append(
                    result.toString() + '<b class="caret"></b>'
                );
            }
        },
        error: function () {
            alert("请求失败!");
        }
    });
}

function updatePwd() {
    var password1 = document.getElementById("password1");
    var password2 = document.getElementById("password2");

    if(password1.value != password2.value){
        alert("两次密码不一致,请重新输入!");
        password1.text="";
        password2.text="";
    }else{
        var data = {};
        data["password"] = password2.value;
        $.ajax({
            url:"updateUserPwd",
            type:"POST",
            data:data,
            dataType:"JSON",
            success:function (result) {
                if(result == true){
                    alert("修改密码成功,请重新登录!");
                    setTimeout('window.location.href="login.html"');
                }
            }
        });
    }
}

function logout() {
    $.ajax({
        url:"logout",
        type:"GET",
        dataType:"JSON",
        success:function (result) {
            if(result == true){
                alert("退出成功!");
                setTimeout('window.location.href="login.html"');
            }else{
                alert("退出失败!");
            }
        },
        error:function () {
            alert("请求失败!");
        }
    });
}