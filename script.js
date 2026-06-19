document.getElementById('generatebtn').addEventListener('click', function() {
    const length = parseInt(document.getElementById('passwordlength').value);
    const includeUpper = document.getElementById('includeupper').checked;
    const includeLower = document.getElementById('includelower').checked;
    const includeNum = document.getElementById('includenum').checked;
    const includeSym = document.getElementById('includesym').checked;

    const UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    const NUMBERS = "1234567890";
    const SYMBOLS = "!@#$%^&*()_=+\\/~?";

    let pool = '';
    if (includeUpper) pool += UPPERCASE_LETTERS;
    if (includeLower) pool += LOWERCASE_LETTERS;
    if (includeNum) pool += NUMBERS;
    if (includeSym) pool += SYMBOLS;

    if (pool.length === 0) {
        alert("Error: At least one character type must be selected.");
        return;
    }

    if (length <= 0) {
        alert("Password length must be greater than 0.");
        return;
    }

    let password = '';
    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * pool.length);
        password += pool[randomIndex];
    }

    document.getElementById('password').value = password;
});
