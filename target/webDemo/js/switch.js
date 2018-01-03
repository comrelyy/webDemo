function changeSwitch(statu) {

    var url = "http://192.168.70.64:8080/webDemo/test/getUser";
    $.ajax({
        async : true,
        url : url,
        data : {
            id : statu
        },
        success : function(result){
            console.log(result);
        }
    })
}
