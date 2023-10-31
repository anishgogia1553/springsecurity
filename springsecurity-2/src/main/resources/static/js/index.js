$('#schedular_name').change(function() {
    var name = $('#schedular_name').val();
    var status = $('#status').val();
    var date = $('#status_date').val();
    var category = $('#category').val();
    console.log(name,status,date,category)
    $.ajax({
        type: 'GET',
        url: '/filteredData',  // Endpoint in your Spring Controller
        data: { 
			name:name,
			status:status,
			date:date,
			category:category
		 },
        success: function(data) {
			console.log(data)
            // Update the table with filtered data
            // You might need to parse the 'data' response and update the table rows accordingly
            console.log('success')
         
        }
    });
});
