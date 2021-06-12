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
