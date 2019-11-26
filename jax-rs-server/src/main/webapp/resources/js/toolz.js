/* Schönes Util aus dem Spring-MVC-Showcase */
MvcUtil = {};
MvcUtil.showSuccessResponse = function(text, element) {
	MvcUtil.showResponse("dunkelblau", text, element);
};
MvcUtil.showErrorResponse = function showErrorResponse(text, element) {
	MvcUtil.showResponse("rot", text, element);
};
MvcUtil.showResponse = function(type, text, element) {
	var responseElementId = element.attr("id") + "Response";
	var responseElement = $("#" + responseElementId);
	if (responseElement.length == 0) {
		responseElement = $(
				'<span id="' + responseElementId + '" class="' + type
						+ '" style="display:none">' + text + '</span>')
				.insertAfter(element);
	} else {
		responseElement.replaceWith('<span id="' + responseElementId
				+ '" class="' + type + '" style="display:none">' + text
				+ '</span>');
		responseElement = $("#" + responseElementId);
	}
	responseElement.fadeIn("slow");
};
MvcUtil.zeigInhalt = function(type, text) {
	var responseElement = $("#layoutInhalt");
	responseElement.replaceWith('<div id="layoutInhalt" class="' + type
			+ '" style="display:none">' + text + '</div>');
	responseElement = $("#layoutInhalt");

	responseElement.fadeIn("slow");
};

MvcUtil.xmlencode = function(xml) {
	// for IE
	var text;
	if (window.ActiveXObject) {
		text = xml.xml;
	}
	// for Mozilla, Firefox, Opera, etc.
	else {
		text = (new XMLSerializer()).serializeToString(xml);
	}
	return text.replace(/\&/g, '&' + 'amp;').replace(/</g, '&' + 'lt;')
			.replace(/>/g, '&' + 'gt;').replace(/\'/g, '&' + 'apos;').replace(
					/\"/g, '&' + 'quot;');
};
