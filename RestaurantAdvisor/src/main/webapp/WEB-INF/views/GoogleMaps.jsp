<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Google Maps API Example: Simple Geocoding</title>
    <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAjU0EJWnWPMv7oQ-jjS7dYxSPW5CJgpdgO_s4yyMovOaVh_KvvhSfpvagV18eOyDWu7VytS6Bi1CWxw"
      type="text/javascript"></script>
      
    <script type="text/javascript">

    var map = null;
    var geocoder = null;

    function initialize() {
      if (GBrowserIsCompatible()) {
        map = new GMap2(document.getElementById("map_canvas"));
        map.setCenter(new GLatLng(37.4419, -122.1419), 1);
        map.setUIToDefault();
        geocoder = new GClientGeocoder();
      }
    }

    function showAddress(address) {
      if (geocoder) {
        geocoder.getLatLng(
          address,
          function(point) {
            if (!point) {
              alert(address + " not found");
            } else {
              map.setCenter(point, 15);
              var marker = new GMarker(point, {draggable: true});
              map.addOverlay(marker);
              GEvent.addListener(marker, "dragend", function() {
                marker.openInfoWindowHtml(marker.getLatLng().toUrlValue(6));
              });
              GEvent.addListener(marker, "click", function() {
                marker.openInfoWindowHtml(marker.getLatLng().toUrlValue(6));
              });
	      GEvent.trigger(marker, "click");
            }
          }
        );
      }
    }
    </script>
  </head>

  <body onload="initialize()" onunload="GUnload()">
    <form action="#" onsubmit="showAddress(this.address.value); return false">
      <p>
        <input type="text" style="width:350px" name="address" value="${addressString}" />
        <input type="submit" value="Go!" />
      </p>
      <div id="map_canvas" style="width: 600px; height: 400px"></div>
    </form>
	
	<form>
		<a href="searchOrderReview"> Go Back </a>
	</form>
  </body>
</html>
