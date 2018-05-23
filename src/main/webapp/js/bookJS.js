function showBook() {
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
});

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