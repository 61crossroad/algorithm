/* 재귀호출을 통한 분할정복을 이용한 퀵소트
 * 평균적으로 o(nlogn)의 시간복잡도를 가지며, 모든 요소가 거꾸로 정렬되어 있을 때 최대 o(n^2)의 시간복잡도를 가진다.
 * 재귀를 사용하지 않는다면 merge sort도 o(nlogn)의 시간복잡도를 기대할 수 있다.
 */

function quicksort(x, first, last) {
    var p = x[Math.floor((first + last) / 2)];
    console.log("quicksort(" + first + ", " + last + ") p = " + p);
    console.log(x);
    // console.log("p = " + p);

    for (var i = first, j = last; ; i++, j--) {
        while (x[i] < p) i++;
        while (p < x[j]) j--;
        
        if (i >= j) {
            console.log("i = " + i + ", j = " + j);
            break;
        }
        // console.log("x[" + i + "] = " + x[i] + " <-> x[" + j + "] = " + x[j]);
        var w = x[i]; x[i] = x[j]; x[j] = w;
        console.log(x);
    }

    if (first < i - 1) quicksort(x, first, i - 1);
    if (j + 1 < last) quicksort(x, j + 1, last);
}

var a = [7, 2, 5, 10, 8, 9, 3];
quicksort(a, 0, a.length - 1);
console.log(a);
