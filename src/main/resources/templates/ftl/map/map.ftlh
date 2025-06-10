<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as m>
<#include "../PARTS/menu.ftl">
<@m.common page="Карта" css="/css/map.css">
    <script src="https://api-maps.yandex.ru/2.1/?apikey=a2737b91-85ee-4441-befd-2436997ef8b8&lang=ru_RU" type="text/javascript">
    </script>
    <script src="../js/map.js" type="text/javascript"></script>

    <div class="wrapper">
        <div class="map-container">
            <ul id="addressList" class="addresses">
                <li data-lat="55.745354" data-lon="49.198585">Республика Татарстан, Казань, Приволжский район, сквер по улице Академика Парина</li>
                <li data-lat="55.733767" data-lon="49.175465">Республика Татарстан, Казань, Приволжский район, жилой комплекс Солнечный Город</li>
                <li data-lat="55.759326" data-lon="49.193550">Республика Татарстан, Казань, Приволжский район, микрорайон Горки-1, 2-й микрорайон</li>
            </ul>
        <div id="map"></div>
    </div>
    </div>
</@m.common>