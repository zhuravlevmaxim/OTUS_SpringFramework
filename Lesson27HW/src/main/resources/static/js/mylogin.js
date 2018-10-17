function myloginCreateForm() {

    var authenticationDiv = document.getElementById("authenticationDiv");

    var authenticationForm = document.createElement("FORM");
    authenticationForm.setAttribute("id", "authenticationForm");
    authenticationForm.setAttribute("class", "authenticationForm");
    authenticationForm.setAttribute("action", "/mylogin");
    authenticationForm.setAttribute("method", "POST");

    var usernameP = document.createElement("P");
    usernameP.innerHTML = "Login: ";
    var usernameInput = document.createElement("INPUT");
    usernameInput.setAttribute("id", "username");
    usernameInput.setAttribute("name", "username");
    usernameP.appendChild(usernameInput);
    authenticationForm.appendChild(usernameP);

    var passwordP = document.createElement("P");
    passwordP.innerHTML = "Password: ";
    var passwordInput = document.createElement("INPUT");
    passwordInput.setAttribute("id", "password");
    passwordInput.setAttribute("name", "password");
    passwordInput.setAttribute("type", "password");
    passwordP.appendChild(passwordInput);
    authenticationForm.appendChild(passwordP);

    var buttonFormEditAuthorCreate = document.createElement("BUTTON");
    buttonFormEditAuthorCreate.innerHTML = "Login";
    buttonFormEditAuthorCreate.setAttribute("type", "submit");
    authenticationForm.appendChild(buttonFormEditAuthorCreate);
    authenticationDiv.appendChild(authenticationForm);
}