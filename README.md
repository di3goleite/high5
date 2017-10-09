# high5 - Simple compiler project

![Successful Deployment](http://tclhost.com/54ZWgkb.gif)

## Input

```
int x = 10;

if (x >= 0 && 1 < 2 || 1 == 1) {
    x = x - 1;
    print(x);
}

```

## Output

```
<int, Reserved Word>
<x, Identifier>
<=, Relational Operator>
<10, Digit>
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
<||, Logic Operator>
<1, Digit>
<==, Identifier>
<1, Digit>
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
<x, Identifier>
<), Delimiter>
<;, Delimiter>
<}, Delimiter>
```