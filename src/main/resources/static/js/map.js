ymaps.ready(init);
function init() {
    var myMap = new ymaps.Map("map", {
        center: [55.7887, 49.1221],
        zoom: 10
    });

    var addressList = document.getElementById('addressList');
    for (var i = 0; i < addressList.children.length; i++) {
        var lat = parseFloat(addressList.children[i].getAttribute('data-lat'));
        var lon = parseFloat(addressList.children[i].getAttribute('data-lon'));
        addPlacemark(lat, lon);
    }

    addressList.addEventListener('click', function(event) {
        var target = event.target;
        if (target.tagName === 'LI') {
            var lat = parseFloat(target.getAttribute('data-lat'));
            var lon = parseFloat(target.getAttribute('data-lon'));
            myMap.setCenter([lat, lon]);
            myMap.setZoom(15);
        }
    });

    function addPlacemark(lat, lon) {
        var coords = [lat, lon];
        var myPlacemark = new ymaps.Placemark(coords);
        myMap.geoObjects.add(myPlacemark);
    }



}
