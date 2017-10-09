# high5 - Simple compiler project

![Successful Deployment](http://tclhost.com/54ZWgkb.gif)

## Input

```
int x = 10;
float y = 3.14;

if (x >= 0 && 1 < 2) {
    x = x - 1;
    print("Result: ");
    print(x * y);
}


```

## Output

```
<int, Reserved Word>
<x, Identifier>
<=, Relational Operator>
<10, Digit>
<;, Delimiter>
<float, Reserved Word>
<y, Identifier>
<=, Relational Operator>
<3.14, Number>
<;, Delimiter>
<if, Reserved Word>
<(, Delimiter>
<x, Identifier>
<>=, Relational Operator>
<0, Digit>
<&&, Logic Operator>
<1, Digit>
<<, Relational Operator>
<2, Digit>
<), Delimiter>
<{, Delimiter>
<x, Identifier>
<=, Relational Operator>
<x, Identifier>
<-, Arithmetic Operator>
<1, Digit>
<;, Delimiter>
<print, Reserved Word>
<(, Delimiter>
<"Result, Identifier>
<:, Delimiter>
<", Identifier>
<), Delimiter>
<;, Delimiter>
<print, Reserved Word>
<(x, Identifier>
<*, Arithmetic Operator>
<y), Identifier>
<;, Delimiter>
<}, Delimiter>
```