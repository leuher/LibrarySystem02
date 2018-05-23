function search() {
    var bookName = document.getElementById("searchTxt");

    var data = {};
    data["bookName"] = bookName.value;

    $.ajax({
        url:"search",
        type:"POST",
        data:data,
        dataType:"JSON",
        success:function (result) {
            console.log(result);
            $("#postTable").html("<tr style=\"font-weight:bold\"><td>书名</td><td>作者</td><td>出版社</td><td>借阅状态</td><td>一键借阅</td></tr>");
            $.each(result, function (i, item) {
                var isrent;
                if(item.isrent == 0){
                    isrent = "在架上";
                    $("#postTable").append(
                        '<tr><td>'+item.bookName+'</td><td>'+item.bookWriter+'</td><td>'+item.Publisher+'</td><td>'+isrent+'</td><td><a class="btn btn-primary btn-xs" href="#" role="button" id="'+item.bookId+'" onclick="borrowBook(this)">借阅</a></td></tr>'
                    );
                }else{
                    isrent = "已借出";
                    $("#postTable").append(
                        '<tr><td>'+item.bookName+'</td><td>'+item.bookWriter+'</td><td>'+item.Publisher+'</td><td>'+isrent + '</td><td><a class="btn btn-primary btn-xs" href="#" disabled="true" role="button" id="'+item.bookId+'">借阅</a></td></tr>'
                    );
                }
            })
        },
        error:function () {
            alert("请求出错!")
        }
    });
}

function borrowBook(obj) {
    var data = {};
    data["id"] = obj.id.toString();
    if(confirm("请确定是否借阅这本书?")){
        $.ajax({
            url:"borrowBook",
            type:"POST",
            data:data,
            datType:"JSON",
            success:function (result) {
                if(result == true){
                    alert("成功借阅!");
                    setTimeout('window.location.href="mybook.html"');
                }
            },
            error:function () {
                alert("请求错误!");
            }
        });
    }
}

function showBorrowBook(){
    $.ajax({
        url: "showBorrow",
        type: "GET",
        success: function(response) {
            $.each(response, function(i, item) {
                $("#borrowPanel").append(
                    '<tr><td>'+item.bookName+'</td><td>'+item.bookWriter+'</td><td>'+item.Publisher+'</td><td><a class="btn btn-primary btn-xs" href="#"  role="button" id="'+item.bookId+'" onclick="returnBook(this)" >归还</a></td></tr>');
            });
        },
        error: function(xhr, msg, e) {
            alert("请求失败!");
        }
    });
}

function returnBook(obj) {
    var data={};
    data["id"]=obj.id.toString();
    if(confirm("请确定是否归还这本书?")){
        $.ajax({
            url:"returnBook",
            type:"POST",
            data:data,
            dataType:"JSON",
            success:function (response) {
                if(response == true){
                    setTimeout('window.location.href="mybook.html"');
                }
            },
            error:function (xhr, msg, e) {
                console.log(e);
            }
        });
    }
}