function exponentialSearch(arr, target) {
  if (arr[0] === target) {
    return 0;
  }
  let i = 1;
  while (i < arr.length && arr[i] <= target) {
    i = i * 2;
  }
  return binarySearch(arr, i / 2, Math.min(i, arr.length), target);
}
function binarySearch(arr, low, high, target) {
  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);
    if (arr[mid] === target) return mid;
    else if (arr[mid] < target) low = mid + 1;
    else high = mid - 1;
  }
  return -1;
}


let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let target = 5;
let result = exponentialSearch(arr, target);
console.log(result);