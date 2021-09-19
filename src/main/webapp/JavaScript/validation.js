function validatePassword (password) {
    var passid_len = password.length;
    var flag = true;

    if (passid_len == 0 ||passid_len >= 25 || passid_len < 8) {
        flag = false;
    }

    return flag;
}
