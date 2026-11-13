# LoginAnalyzer

A small command-line Java program that simulates a login system and flags suspicious activity. I built it as a learning project during my first year of Computer Science, as an early step toward my goal of working in cybersecurity.

> **Note:** This is a learning exercise, not a real authentication system. The usernames and passwords are hardcoded in plaintext, which is something real systems should never do.

## What it does

- Prompts the user for a username and password.
- Checks the credentials against two hardcoded accounts.
- Tracks failed login attempts **globally** and **per account**.
- Flags the session as suspicious after more than 2 failed attempts overall.
- Adds an account to a suspicious accounts list after more than 2 failed attempts on that account.
- Locks the session after 5 failed attempts.
- Prints a report at the end showing the suspicious accounts and the session flag status.

## How to run

You need the JDK installed (Java 8 or newer).

```bash
javac LoginAnalyzer.java
java LoginAnalyzer
```

For testing, the accounts are `username1` / `password1` and `username2` / `password2`.

## Example

```
Enter your username
username1
Enter your password
wrong
Login Failed. Try again
...
You have failed to login 5 consecutive times. Your activity has been suspended.
report:
suspicious accounts: [username1]
SessionFlagStatus:1
```

## What I learned

**Java fundamentals**
- Reading user input with `Scanner`
- Using `while` loops and `if / else if / else` chains to control program flow
- Comparing strings with `.equals()` instead of `==`
- Using `ArrayList` and checking `contains()` to avoid duplicate entries
- Keeping counters and flags to track program state

**Security concepts I was introduced to**
- Lockouts and attempt limits are a basic defense against brute force attacks
- Real systems store salted password hashes (bcrypt, Argon2), never plaintext passwords
- A login system should respond the same way to a wrong username as to a wrong password, so it doesn't reveal which usernames exist
- Per-account counters help catch brute force attempts, while global or per-IP counters help catch credential stuffing

## Ideas for improvement

- [ ] Refactor to use `Map`s so adding accounts doesn't mean copy-pasting code
- [ ] Use `boolean` for the session flag
- [ ] Reset counters after a successful login or after a time window
- [ ] Hash passwords instead of storing them in plaintext
- [ ] Hide password input while typing
- [ ] Log events to a file

## Author

First-year CS student learning Java and working toward a career in cybersecurity.
