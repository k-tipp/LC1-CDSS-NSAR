$(document).ready(function() {
	
	  // create an array with nodes
	  // create an array with nodes
	  var textSize = 20;
	  
	  var nodes = new vis.DataSet([
	    {id: 1, label: 'Medication 1', color:'#FFFFFF', shape: 'box', font: {size: textSize}},
	    {id: 2, label: 'Medication 2', color:'#FFFFFF', shape: 'box', font: {size: textSize}},
	    {id: 3, label: 'Medication 3', color:'#FFFFFF', shape: 'box', font: {size: textSize}},
	    {id: 4, label: 'Patient', color:'#FFFFFF', shapeProperties: {x: 300, y: 200}, image: '/cdss4nsar/resources/img/clipart_human.png', shape: 'image', font: {size: textSize}, size: textSize + 10},
	    {id: 5, label: 'Medication 4', color:'#FFFFFF', shape: 'box', font: {size: textSize}},
	    {id: 6, label: 'Medication 5', color:'#FFFFFF', shape: 'box', font: {size: textSize}},
	    {id: 7, label: 'Medication 6', color:'#FFFFFF', shape: 'box', font: {size: textSize}},
	    {id: 8, label: 'Medication 7', color:'#FFFFFF', shape: 'box', font: {size: textSize}}
	  ]);

	  // create an array with edges
	  var edges = new vis.DataSet([
	    {from: 1, to: 8, color:{color:'red'}, width: 5},
		{from: 1, to: 8, color:{color:'blue'}, width: 5},
	    {from: 1, to: 3, color:{color:'red'}, width: 5},
	    {from: 1, to: 2, color:{color:'red'}, width: 5},
	    {from: 2, to: 4, color:{color:'red'}, width: 5},
	    {from: 2, to: 5, color:{color:'red'}, width: 5},
	    {from: 5, to: 6, color:{color:'red'}, width: 5},
	    //{from: 6, to: 7, color:{color:'#ff0000', opacity:0.3}, width: 5},
	   // {from: 6, to: 8, color:{opacity:0.3}, width: 5},
	  ]);


	  // create a network
	  var container = document.getElementById('mynetwork');
	  var data = {
	    nodes: nodes,
	    edges: edges
	  };
	  var options = {
		interaction: {
			selectable: false,
			selectConnectedEdges: false,
			dragView: false,
		},
		physics:{
			enabled: true,
			forceAtlas2Based: {
				damping: 0.1,
				springConstant: 0.01,
				gravitationalConstant: -50,
				centralGravity: 0.01,
				
			},
			solver: 'forceAtlas2Based',
			stabilization: {
				iterations: 1000,
				fit: true,
			},
		},
		edges: {
			smooth: true,
			labelHighlightBold: false,
			  color: {
				highlight: false,
			  },
			physics: true,
			length: 100,
		},
		nodes: {
		//	physics: false,
			  labelHighlightBold: false,
			  color: {
				highlight: false,
			  },
			    radiusMin: 5,
	            radiusMax: 10,
		},
		layout: {
			improvedLayout: true,
		},
		};
	  var network = new vis.Network(container, data, options);

});