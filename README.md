# high5 - Simple compiler project

![Successful Deployment](http://tclhost.com/54ZWgkb.gif)

## Input

```
int x = 10;
float y = 3.14;

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
<10, Identifier>
<;, Delimiter>
<float, Reserved Word>
<y, Identifier>
<=, Relational Operator>
<3.14, Number>
<;, Delimiter>
</*
    This is a block comment
*/, Block Comment>
<if, Reserved Word>
<(, Delimiter>
<x, Identifier>
<>=, Relational Operator>
<0, Identifier>
<&&, Logic Operator>
<1, Identifier>
<<, Relational Operator>
<2, Identifier>
<), Delimiter>
<{, Delimiter>
<x, Identifier>
<=, Relational Operator>
<x, Identifier>
<-, Arithmetic Operator>
<1, Identifier>
<;, Delimiter>
<// Print the result
, Line Comment>
<print, Reserved Word>
<(, Delimiter>
<"Result: ", Characters Chain>
<);, Identifier>
<print, Reserved Word>
<(x, Identifier>
<*, Arithmetic Operator>
<y);, Identifier>
<}, Delimiter>
```