# Problem : Fibonacci encryption and decryption

A password encryption algorithm on a pair of source message (plain text) and password, containing lowercase and uppercase letters only, is explained through example as below: 

Source Message is: abcd 
Password is: xyz 

# Steps in the Encryption Algorithm 

The source message is reversed i.e abcd is written as dcba.
The password is appended i.e the cipher text becomes dcbaxyz.
The Fibonacci series, up to the length of the password is generated. In our case, the password length is 3, so the first three Fibonacci terms viz. 1, 1, 2 are generated. Start the Fibonacci series from 1 instead of 0.
Every element in odd position in the cipher text is forwarded by the current Fibonacci term, i.e. in the first iteration all odd indexed elements would be advanced by 1, in the second iteration by 1, in the third iteration by 2 and so on. Once 'z' is reached, we wrap around i.e. if we forward 'z' or 'Z' by 1 the output would be 'a' or 'A'. 

Similarly, every element in even position in the cipher text is reversed by the current Fibonacci term, i.e. in the first iteration all even elements would be reversed by 1, in the next iteration by 1, in the next by 2 and so on. Once 'a' is reached, wrap around i.e. if we reverse 'a' or 'A' by 1 the output would be 'z' or 'Z'.
So, in our case the Encryption iteration for the cipher text 'dcbaxyz' would be, 
ebczyxa when the current fibonacci term is 1
fadyzwb when the current fibonacci term is 1
hyfwbud when the current fibonacci term is 2
So, our resultant encrypted string would be 'hyfwbud'.

# Steps in the Decryption Algorithm

Decryption operation is the reverse of encryption operation. For e.g. if encrypted text is 'hyfwbud', and password is xyz, then the decryption steps are as below:

Password length is 3, hence number of Fibonacci terms are 3 viz. 1, 1, 2
First iteration on ecrypted text when the current fibonacci term is 1 will be gzexavc
Second iteration on gzexavc when the current fibonacci term is 1 will be fadyzwb
Third iteration on fadyzwb when the current fibonacci term is 2 will be dcbaxyz
If L is the password length, 3 in this case, then extract last L characters from ciphertext i.e. dcbaxyz and match it with password provided in input. 
If password matches, reverse the remaining text which will be the original clear text i.e. abcd
If password does not match, then clear text cannot be obtained. See output specifications for more details