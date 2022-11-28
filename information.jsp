<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./assets/dist/css/bootstrap.min.css">
	<title>About yourself</title>
</head>
<body>

	<div class="container">
		<div class="row mt-3 form-container">
			<div class="title row">
				<h2 class="titles text-decoration-underline text-center">
					About Yourself
				</h2>
			</div>
			<div class="forms">
				
				<form action="">
					
					<div class="mb-3">
						<label for="salary" class="form-label">
							Insert your salary : 
						</label>
						<input type="number" name="salary" id="salary" min="0" class="fomr-control">
					</div>
					
					<div class="mb-3">
						<label for="nationality" class="form-label">
							Choose your nationality : 
						</label>
						<select name="nationality" id="nationality" class="form-select">
							<option selected disabled hidden> Nationality ... </option>
							<option value="Malagasy"> Malagasy (Madagascar) </option>
							<option value="other"> Others... </option>
						</select>
					</div>

					<div class="mb-3">
						<label for="finoana" class="form-label">
							Are you a religious person ? 
						</label>
						<select name="finoana" id="finoana" class="form-select">
							<option selected disabled hidden> Religious or not ?</option>
							<option value="Yes"> Yes (Religious) </option>
							<option value="No"> No </option>
						</select>
					</div>
					<div class="mb-3">
						<label for="degrees" class="form-label">
							Your study degrees :
						</label>
						<select name="diplome" id="degrees" class="form-select">
							<option selected disabled hidden> Choose your degree : </option>
							<option value="Bacc"> Bacc </option>
							<option value="Bacc+1"> Bacc + 1 </option>
							<option value="Bacc+2"> Bacc + 2 </option>
							<option value="Bacc+3"> Bacc + 3 </option>
							<option value="Bacc+4"> Bacc + 4 </option>
							<option value="Bacc+5"> Bacc + 5 </option>
						</select>
					</div>
					<div class="mb3">
						<label for="longeur" class="form-label">
							How tall are you :
						</label>
						<input type="number" class="fomr-control" name="longeur" id="longeur">
					</div>
					<div class="mb-3">
						<label for="Age" class="form-label">
							Your birth Date :
						</label>
						<input type="date" class="fomr-control" name="age" id="Age">
					</div>

				</form>
			</div>
		</div>
	</div>
	
	<script src="./assets/dist/css/bootstrap.min.css"> </script>
</body>
</html>