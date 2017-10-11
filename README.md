# high5 - Simple compiler project

![Successful Deployment](http://tclhost.com/54ZWgkb.gif)

## Input

```
int 1x = 10;
float _y = 3.14;
int x_y = 9;

/*
    This is a block comment
*/
if (x >= 0 && 1 < 2) {
    x = x - 1;

    // Print the result
    print("Result: ");
    print(x * y);
}
```

## Output

```
<int, Reserved Word>
<x, Identifier>
<=, Relational Operator>
<10, Number>
<;, Delimiter>
<float, Reserved Word>
<y, Identifier>
<=, Relational Operator>
<3.14, Number>
<;, Delimiter>
</*
    This is a block comment
*/, Block Comment>
<int, Reserved Word>
<1x, (Identifier)_Malformed>
<=, Relational Operator>
<10, Number>
<;, Delimiter>
<float, Reserved Word>
<_y, (Identifier)_Malformed>
<=, Relational Operator>
<3.14, Number>
<;, Delimiter>
<int, Reserved Word>
<x_y, Identifier>
<=, Relational Operator>
<9, Number>
<;, Delimiter>
</*
    This is a block comment
*/, Block Comment>
<if, Reserved Word>
<(, Delimiter>
<x, Identifier>
<>=, Relational Operator>
<0, Number>
<&&, Logic Operator>
<1, Number>
<<, Relational Operator>
<2, Number>
<), Delimiter>
<{, Delimiter>
<x, Identifier>
<=, Relational Operator>
<x, Identifier>
<-, Arithmetic Operator>
<1, Number>
<;, Delimiter>
<// Print the result, Line Comment>
<print, Reserved Word>
<(, Delimiter>
<"Result: ", Characters Chain>
<), Delimiter>
<;, Delimiter>
<print, Reserved Word>
<(, Delimiter>
<x, Identifier>
<*, Arithmetic Operator>
<y, Identifier>
<), Delimiter>
<;, Delimiter>
<}, Delimiter>
```