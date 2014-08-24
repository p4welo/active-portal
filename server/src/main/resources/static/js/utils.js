function getRestUrl(uri)
{
    var REST_PART = "/ap/rest/company";
    return REST_PART + uri;
//    return SERVER_URL + REST_PART + uri;
}

function getPublicUrl(uri)
{
    var PUBLIC_PART = "/public";
    return SERVER_URL + PUBLIC_PART + uri;
}

function hideModal(id) {
    $(id).modal("hide");
}

function showModal(id) {
    $(id).modal("show");
}