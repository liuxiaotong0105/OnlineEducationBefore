$(function(){
    initMovie();
})
function searchBtn(x){
    $('#movieType').val(x);
    initMovie();
}
function initMovie(){
    alert($('#names').val())
    alert($('#movieType').val())
    $.ajax({
        url:'../getMovie',
        type:'post',
        data:{
            movieType:$('#movieType').val(),
            movieName:$('#names').val()
        },
        success:function(data){
            var html = "";
            alert(data.length)
            for (var i = 0;i<data.length;i++){
                html+=
                    '<div class="col-sm-4 col-xs-12 mix kinder play">' +
                    '                    <div class="single-class">' +
                    '                        <div class="class-img">' +
                    '                            <img alt="" src="'+data[i].moviePicther+'">' +
                    '                        </div>' +
                    '                        <div class="class-details">' +
                    '                            <h3><a href="class.html">'+data[i].movieName+'</a></h3>' +
                    '                            <p>'+data[i].movieType+'</p>' +
                    '                            <div class="clearfix">' +
                    '                                <div class="class-meta pull-left">' +
                    '                                    <span>所属阶段</span>' +
                    '                                    <p>'+data[i].movieClass+'</p>' +
                    '                                </div>' +
                    '                                <div class="class-meta pull-left">' +
                    '                                    <span>讲课老师</span>' +
                    '                                    <center><p>'+data[i].teacherName+'</p></center>' +
                    '                                </div>' +
                    '                                <div class="class-meta pull-left">' +
                    '                                    <span>课程费用</span>' +
                    '                                    <center><p>'+data[i].moviePrice+'</p></center>' +
                    '                                </div>' +
                    '                            </div>' +
                    '                        </div>' +
                    '                    </div>' +
                    '                </div>';
            }
            $('#mm').html(html);
        }
    })
}