function map() {
	var mapContainer = document.getElementById('map'),
    mapOption = { 
        center: new daum.maps.LatLng(37.502529, 127.024760),
        level: 3
    }; 

	var map = new daum.maps.Map(mapContainer, mapOption);

	var marker = new daum.maps.Marker({
	    map: map, 
	    position: new daum.maps.LatLng(37.502529, 127.024760)
	});

	var content = '<div class="wrap">' + 
	            '    <div class="info">' + 
	            '        <div class="title">' + 
	            '            호호 베이커리' + 
	            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
	            '        </div>' + 
	            '        <div class="body">' + 
	            '            <div class="img">' +
	            '                <img src="${img}" width="73" height="70">' +
	            '           </div>' + 
	            '            <div class="desc">' + 
	            '                <div class="ellipsis">서울 서초구 서초대로77길 54</div>' + 
	            '                <div class="jibun ellipsis">서초W타워 13,14층</div>' + 
	            '                <div><a href="http://map.daum.net/link/map/호호 베이커리,37.502529,127.024760">길찾기 하러가기</a></div>' + 
	            '            </div>' + 
	            '        </div>' + 
	            '    </div>' +    
	            '</div>';

	var overlay = new daum.maps.CustomOverlay({
	    content: content,
	    map: map,
	    position: marker.getPosition()       
	});

	daum.maps.event.addListener(marker, 'click', function() {
	    overlay.setMap(map);
	});

	function closeOverlay() {
	    overlay.setMap(null);     
	}
}