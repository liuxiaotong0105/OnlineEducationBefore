function chass(){
    var name=$("#names").val();
    var x="";
    $.ajax({
        type: "post",
        url: "../user/queryAllUsers",
        data: {
            name:name,
        },
        dataType: "json",
        success: function (ms) {
            for (var i = 0; i <ms.length; i++) {
                x+=ms.get(i);
            }
            alert(x);
        }
    });

}
