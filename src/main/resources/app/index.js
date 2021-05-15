function Submit(){
var a = document.querySelector('#a')
var b = document.querySelector('#b')
var c = document.querySelector('#c')
if(a.value !== '' && b.value !== '' && b.value !== ''){
    var result = calculate(a.value, b.value, c.value)
    document.getElementById('result').textContent = result
    var xhr = new XMLHttpRequest()
    var url = 'http://localhost:8080/api/save'
    xhr.open("POST", url, true)
    xhr.setRequestHeader('Content-Type', 'application/json')
    var data = JSON.stringify({'a': a.value, 'b': b.value, 'c': c.value, 'result': result})
    console.log(data);
    xhr.send(data);
    /*$.ajax({
        url: 'http://localhost:8080/api/save',
        type: 'POST',
        data: JSON.stringify({'a': a.value, 'b': b.value, 'c': c.value, 'result': '123'}),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: false,
    });*/
    }
    else
        document.getElementById('result').textContent = 'Coefficients must be not null'
}
function calculate(a, b, c)
{
    var D = b * b - 4 * a * c;
    if(D >= 0)
    {
        return 'x1 = '+ (-(b) + Math.sqrt(D)) / (2 * a) + ', x2 = ' + (-(b) - Math.sqrt(D)) / (2 * a);
    }
    return "Not found";
}