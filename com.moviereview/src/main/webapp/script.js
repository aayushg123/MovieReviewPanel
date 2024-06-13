var hostId = null;
var PropertyId = null;

var moviesArr = [];
var usersArr = [];


var user = {
	userId: null,
	userName: "",
	userEmail: "",
	userPassword: ""

};

var movie = {
	movieId: null,
	movieName:"",
	movieLanguage:"",
	movieYear:null,
	movieGenre:"",
	trailerUrl:"",
	smallPoster:"",
	desc:"",
	actors:"",
	director:"",
	production:"",
	writer:"",
	rating:null
};

function getHost() {
	document.getElementById("editMovie").hidden = true;
	document.getElementById("my-profile").hidden = false;
	document.getElementById("viewMovies").hidden = true;
	document.getElementById("addMovies").hidden = true;
	document.getElementById("editUser").hidden = true;
	document.getElementById("viewUsers").hidden = true;
	

	document.getElementById("hostName").innerHTML =
		"<span>Name: </span>" + host.hostName;
	document.getElementById("hostEmail").innerHTML =
		"<span>Email: </span>" + host.hostEmail;
	document.getElementById("hostBio").innerHTML =
		"<span>Bio: </span>" + host.hostBio;

	document.getElementById("hostName1").innerHTML = host.hostName;
	document.getElementById("hostEmail1").innerHTML = host.hostEmail;
	document.getElementById("hostBio1").innerHTML = host.hostBio;
}

function signUp() {
	const hostData = {
		hostName: document.getElementById("signUpName").value,
		hostEmail: document.getElementById("signUpEmail").value,
		hostPassword: document.getElementById("signUpPassword").value,
		hostBio: document.getElementById("signUpBio").value,
	};
	console.log(hostData);

	fetch("http://localhost:8080/postbook/webapi/airbnb/hosts/add", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(hostData),
	})
		.then((resp) => {
			if (resp.status === 200) {
				alert("You have Register Successfully !");
				return resp.json();
			} else if (resp.status === 204) {
				// No content
				throw new Error("Something is wrong Try again.");
			}
		})
		.then((data) => {
			window.location.assign("/postbook/main.html");
			console.log(data);
		});
}

function signIn() {
	const hostEmailInput = document.getElementById("signInEmail");
	const hostPasswordInput = document.getElementById("signInPassword");
	const hostData = {
		hostEmail: hostEmailInput.value,
		hostPassword: hostPasswordInput.value,
	};
	hostEmailInput.value = "";
	hostPasswordInput.value = "";

	fetch("http://localhost:8080/postbook/webapi/airbnb/hosts/login", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(hostData),
	})
		.then((resp) => {
			if (resp.status === 200) {
				// Successful login
				console.log("success");
				alert("Logged In Successfully!");
				// document.getElementById("feed-tab").disabled = false;
				// document.getElementById("profile-tab").disabled = false;
				// document.getElementById("my-tweets-tab").disabled = false;
				// document.getElementById("sign-in-tab").hidden = true;
				document.getElementById("login").hidden = true;
				document.getElementById("options").hidden = false;
				//document.getElementById("logout-tab").hidden = false;
				// getTweets();
				// const feedTabButton = document.getElementById("feed-tab");
				// feedTabButton.click();
				//document.getElementById("alert").className=document.getElementById("alert").className+" alert alert-success";
				//document.getElementById("alertTitle").innerText="Success";
				//document.getElementById("alertMsg").innerText="Sign In Successfully !";
				// document.getElementById("alertMsg").hidden=false;
				//alert("Please enter correct details ");
				//document.getElementById("alertClose").hidden=false;
				return resp.json();
			} else if (resp.status === 204) {
				// No content
				throw new Error("error 204");
			}
		})
		.then((data) => {
			host.hostId = data.hostId;
			host.hostName = data.hostName;
			host.hostEmail = data.hostEmail;
			host.hostPassword = data.hostPassword;
			host.hostBio = data.hostBio;
			console.log(data);
		})
		.catch((error) => {
			console.error("Error:", error);
			alert("Email Id or Password is Wrong !");
			// document.getElementById("alert").className=document.getElementById("alert").className+" alert alert-danger";
			//document.getElementById("alertTitle").innerText="Danger";
			//document.getElementById("alertMsg").innerText="Please enter correct details ";
			//document.getElementById("alertMsg").hidden=false;
			//alert("Please enter correct details ");
			//document.getElementById("alertClose").hidden=false;
		});
}

//http://localhost:8080/postbook/webapi/airbnb/hosts/updateHost

function editMenu() {
	document.getElementById("my-profile").hidden = true;
	document.getElementById("editMovie").hidden = false;
	document.getElementById("viewMovies").hidden = true;
	document.getElementById("viewUsers").hidden = true;
	document.getElementById("addMovies").hidden = true;
	}

function edit() {
	const hostName = document.getElementById("hostName2").value;
	const hostBio = document.getElementById("hostBio2").value;

	host.hostName = hostName;
	host.hostBio = hostBio;

	fetch("http://localhost:8080/postbook/webapi/airbnb/hosts/updateHost", {
		method: "PUT",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(host),
	})
		.then((resp) => {
			resp.json();
		})
		.then((data) => {
			console.log("edited: " + data);
			alert("Profile Edited!");
			getHost();
		});
}

function addMovie() {
	document.getElementById("my-profile").hidden = true;
	document.getElementById("editMovie").hidden = true;
	document.getElementById("viewMovies").hidden = true;
	document.getElementById("viewUsers").hidden = true;
	document.getElementById("addMovie").hidden = false;
}


function viewMenu() {
	document.getElementById("my-profile").hidden = true;
	document.getElementById("editMovie").hidden = true;
	document.getElementById("viewMovies").hidden = false;
	document.getElementById("viewUsers").hidden = true;
	document.getElementById("addMovie").hidden = true;
	getAllMovies();
}
function viewUser() {
	document.getElementById("my-profile").hidden = true;
	document.getElementById("editMovie").hidden = true;
	document.getElementById("viewUsers").hidden = false;
	document.getElementById("viewMovies").hidden = true;
	document.getElementById("addMovie").hidden = true;
	getAllUsers();
}
function getAllUsers() {
	fetch(`http://localhost:8080/com.moviereview/webapi/moviereview/users/all`, {
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},
	})
		.then((res) => res.json())
		.then((data) => {
			Object.assign(usersArr, data);
			console.log("Data in movieArr:", data);
			propertyToUsersCard(usersArr);
		});
}

function getAllMovies() {
	fetch(`http://localhost:8080/com.moviereview/webapi/moviereview/movies/all`, {
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},
	})
		.then((res) => res.json())
		.then((data) => {
			Object.assign(moviesArr, data);
			console.log("Data in movieArr:", data);
			propertyToCard(data);
		});
}
function propertyToUsersCard(usersArr) {
	// loop the array....
	var st = "";

	for (let i = 0; i < usersArr.length; i++) {
		st += `<div class="user-card">
                    <img src= "https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-PNG-Photos.png" alt="avtarImg">
					<h2 class="user-name" style="color: #fff;">${usersArr[i].userName}</h2>        		
                    <p style="color: #fff;">Email: ${usersArr[i].userEmail}</p>
                    
					<div class="actions">
					<button class="btn btn-success" onclick="editUserPage('${usersArr[i].userId}','${usersArr[i].userName}','${usersArr[i].userEmail}', '${usersArr[i].userPassword}')" >Edit User</button>
                <button class="btn btn-danger" onclick="deleteUser(${usersArr[i].userId})" >Delete User</button>
            </div>
			</div>`;

	}

	document.getElementById("userList").innerHTML = st;
}

function propertyToCard(moviesArr) {
	// loop the array....
	var st = "";

	for (let i = 0; i < moviesArr.length; i++) {
		st += `<div class="movie-card">
                    <img src= "${moviesArr[i].smallPoster}" alt="Movie Poster">
					<h2 class="movie-name" style="color: #fff;">${moviesArr[i].movieName}</h2>
					<div class="movie-misc">
            		<div class="rating">
					<span class="star">&#9733;</span>
					<span class="star">${moviesArr[i].rating}</span>
            		</div>
                    <p style="color: #fff;">Actors: ${moviesArr[i].actors}</p>
                    
					<div class="actions">
                <button class="btn btn-success" onclick="editMoviePage('${moviesArr[i].movieId}','${moviesArr[i].movieName}','${moviesArr[i].desc}', '${moviesArr[i].movieYear}','${moviesArr[i].movieLanguage}', '${moviesArr[i].movieGenre}','${moviesArr[i].smallPoster}', '${moviesArr[i].trailerUrl}',  '${moviesArr[i].actors}','${moviesArr[i].writer}','${moviesArr[i].director}','${moviesArr[i].production}')">Edit Details</button>
                <button class="btn btn-danger" onclick="deleteMovie(${moviesArr[i].movieId})" >Delete movie</button>
                </div>
            </div>
			</div>`;

	}

	document.getElementById("movieList").innerHTML = st;
}

function deleteMovie(movieId) {
	fetch(
		`http://localhost:8080/com.moviereview/webapi/moviereview/movies/delete/${movieId}`,
		{
			method: "DELETE",
			headers: {
				"Content-Type": "application/json",
			},
		}
	)
		.then((response) => {
			if (response.ok) {
				console.log("Movie deleted successfully.");
				alert("Movie deleted successfully.");
				viewMenu();
			} else {
				throw new Error("Failed to delete movie. Status: " + response.status);
			}
		})
		.catch((error) => {
			console.error("Error deleting movie:", error);
		});
}

function deleteUser(userId) {
	fetch(
		`http://localhost:8080/com.moviereview/webapi/moviereview/users/deleteProfile/${userId}`,
		{
			method: "DELETE",
			headers: {
				"Content-Type": "application/json",
			},
		}
	)
		.then((response) => {
			if (response.ok) {
				alert("User deleted successfully.");
				viewUser();
			} else {
				throw new Error("Failed to delete User. Status: " + response.status);
			}
		})
		.catch((error) => {
			console.error("Error deleting User:", error);
		});
}

function editUserPage(id,name,email,pass) {
	
	document.getElementById("viewUsers").hidden = true;
	document.getElementById("editUser").hidden = false;
	user.userId=id;
	user.userName=name;
	user.userEmail=email;
	user.userPassword=pass;
	


	document.getElementById("name2").setAttribute ('value',name);
	document.getElementById("email2").setAttribute ('value',email);
	document.getElementById("pass2").setAttribute ('value',pass);

}

function editMoviePage(id,name,desc,year,lang,genre,poster,trailer,actor,writer,director,prod) {
	
	document.getElementById("viewMovies").hidden = true;
	document.getElementById("editMovie").hidden = false;
	movie.movieId=id;
	movie.movieName=name;
	movie.desc=desc;
	movie.movieYear=year;
	movie.movieLanguage=lang;
	movie.movieGenre=genre;
	movie.smallPoster=poster;
	movie.trailerUrl=trailer;
	movie.actors=actor;
	movie.writer=writer;
	movie.director=director;
	movie.production=prod;

	
	document.getElementById("name1").setAttribute ('value',name);
	document.getElementById("language1").setAttribute ('value',lang);
	document.getElementById("genre1").setAttribute ('value',genre);
	document.getElementById("posterLink1").setAttribute ('value',poster);
	document.getElementById("trailerLink1").setAttribute('value',trailer);
	document.getElementById("releaseYear1").setAttribute('value',year);
	document.getElementById("actorNames1").setAttribute('value',actor);
	document.getElementById("writer1").setAttribute('value',writer);
	document.getElementById("Director1").setAttribute('value',director);
	document.getElementById("Production1").setAttribute('value',prod);
	document.getElementById("desc1").value = desc;

}


function editMovie() {

	 
	fetch(
		`http://localhost:8080/com.moviereview/webapi/moviereview/movies/update/${movie.movieId}`,
		{
			method: "PUT",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify({
				movieName: document.getElementById("name1").value,
				desc: document.getElementById("desc1").value,
				movieYear: document.getElementById("releaseYear1").value,
				movieLanguage: document.getElementById("language1").value,
				movieGenre: document.getElementById("genre1").value,
				smallPoster: document.getElementById("posterLink1").value,
				trailerUrl: document.getElementById("trailerLink1").value,
				actors: document.getElementById("actorNames1").value,
				writer: document.getElementById("writer1").value,
				director: document.getElementById("Director1").value,
				production: document.getElementById("Production1").value,
			}),
		}
	)
		.then((response) => {
			if (response.ok) {
				alert("Movie details edited successfully.");
				viewMenu();
			} else {
				throw new Error("Failed to update movie. Status: " + response.status);
			}
		})
		.catch((error) => {
			console.error("Error updating movie:", error);
		});
}
function editUser() {

	 
	fetch(
		`http://localhost:8080/com.moviereview/webapi/moviereview/users/updateProfile`,
		{
			method: "PATCH",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify({
				userId:user.userId,
				userName: document.getElementById("name2").value,
				userEmail: document.getElementById("email2").value,
				userPassword: document.getElementById("pass2").value,
				
			}),
		}
	)
		.then((response) => {
			if (response.ok) {
				console.log("Users details edited successfully.");
				alert("User details edited successfully.");
				viewUser();
			} else {
				throw new Error("Failed to update user details. Status: " + response.status);
			}
		})
		.catch((error) => {
			console.error("Error updating user detail:", error);
		});
}
// Example usage: Get the movie ID to delete and then call deleteMovie function

function logout() {
	alert("Logout Successfully");
	window.location.assign("./movie.html");
}
