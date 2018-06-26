function empty(x) {
	if (x == "" || x == null)
		return true;
	return false;
}

function dataToJSON(a, b, c) {
	return JSON.stringify({
		"name" : a,
		"cnpj" : b,
		"template" : c,
	});
}

function formToJSON() {
	return JSON
			.stringify({
				"name" : document.getElementById("idname").value,
				"cnpj" : document.getElementById("idcnpj").value,
				"template" : document
						.querySelector('input[name=template]:checked').value,
			});
}

function deleteShop(cnpj){
	var remove = new XMLHttpRequest();
	remove.open("DELETE", "http://localhost:8080/DBRest/rest/shop/remove",
			true);
	remove.setRequestHeader("Content-Type", "application/json");
	remove.send(cnpj);
	updateShopTable();
}

function updateShopTable() {
	table = document.getElementById("idtable");
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function() {
		if (ajax.readyState == XMLHttpRequest.DONE) {
			if (ajax.status == 200) {
				table.innerHTML = "";
				var json = JSON.parse(ajax.responseText);

				for ( var i in json) {
					var row = table.insertRow(0);

					var cell1 = row.insertCell(0);
					cell1.innerHTML = json[i].name;

					var cell2 = row.insertCell(1);
					cell2.innerHTML = json[i].cnpj;

					var cell3 = row.insertCell(2);
					var d = document.createElement("button");
					d.innerHTML = "delete";
					d.onclick = function(event) {
						deleteShop(json[i].cnpj);
					}
					cell3.appendChild(d);

					var cell4 = row.insertCell(3);
					var g = document.createElement("button");
					g.id = i;
					g.innerHTML = "go";
					g.onclick = function(event) {
						goToShop(json[this.id].name, json[this.id].cnpj,
								json[this.id].template);
					}
					cell4.appendChild(g);
				}

				if (i != null) {
					var header = table.createTHead();
					var row = header.insertRow(0);
					var hcell1 = row.insertCell(0);
					var hcell2 = row.insertCell(1);
					hcell1.innerHTML = "<b>Name</b>";
					hcell2.innerHTML = "<b>CNPJ</b>";
				}

			} else
				console.log('bad update: ' + ajax.status);
		}
	};
	ajax.open("GET", "http://localhost:8080/DBRest/rest/shop/readAll", true);
	ajax.send(null);
}
