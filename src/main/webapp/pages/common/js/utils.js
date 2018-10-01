// 时间戳转换成时间
function time2str(val) {
    if (val == 0) {
        return "";
    }
    let now = new Date(parseInt(val, 10));
    let _year = now.getFullYear(),
        _month = Number(now.getMonth()) + 1,
        _day = now.getDate(),
        _hour = now.getHours(),
        _min = now.getMinutes(),
        _sec = now.getSeconds();
    return `${_year}年${_month}月${_day}日`;
}
// 时间戳转换成时间--包含时分秒
function time2str2(val) {
    if (val == 0) {
        return "";
    }
    let now = new Date(parseInt(val, 10));
    let _year = now.getFullYear(),
        _month = Number(now.getMonth()) + 1,
        _day = now.getDate(),
        _hour = now.getHours(),
        _min = now.getMinutes(),
        _sec = now.getSeconds();
    return `${_year}-${_month}-${_day} ${_hour}:${_min}:${_sec}`;
}
// 时间转时间戳
function toTimestamp(time) {
    let date = new Date(time);
    return date.getTime();
}