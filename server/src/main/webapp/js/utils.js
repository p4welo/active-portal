function getRestUrl(uri)
{
    var REST_PART = "/rest";
    return SERVER_URL + REST_PART + uri;
}

function getPublicUrl(uri)
{
    var PUBLIC_PART = "/public";
    return SERVER_URL + PUBLIC_PART + uri;
}

function hideModal(id) {
    $(id).modal("hide");
}