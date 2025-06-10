function handleRoleVisibility(radio) {
    var roleCell = document.getElementById('roleList');
    if (radio.id === 'yes_block' || radio.id === 'no_block') {
        roleCell.style.display = 'none';
    } else {
        roleCell.style.display = '';
    }
}
function handleRoleVisibilityAfterLoadWindow() {
    var roleList = document.getElementById('roleList');
    var noRadio = document.getElementById('no_block');

    if (noRadio.checked) {
        roleList.style.display = 'none';
    } else {
        roleList.style.display = '';
    }
}

window.onload = function() {
    handleRoleVisibilityAfterLoadWindow();
};