#//tag: strings palindrome

# basically you need to say the result is palindrome are not but based on a condition which is 
# prefix(string1)+suffix(string2) at a index i(ith ele is included in sufix) or sufix(string1)+prefix(string2) if any one in this is palinderome then return true else 
# return false 


# '''
# Input Two strings str1 and str2 of same length. 
# Split both strings at the same index. 
# Splitting str1 into two strings will give prefix1 and suffix1
# Splitting Str2 into two strings will give prefix2 and suffix2

# Check if prefix1 + suffix2 or prefix2 + suffix1 forms a palindrome.
# Return true if it is possible to form a palindrome string, 
# otherwise return false.

# When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. 
# For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.


# Notice that x + y denotes the concatenation of strings x and y.

# Sample Test Cases:
# Example 1:
# Input: a = "x", b = "y"
# Output: true
# Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
# aprefix = "", asuffix = "x"
# bprefix = "", bsuffix = "y"
# Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.

# Example 2:
# Input: a = "xbdef", b = "xecab"
# Output: false

# Example 3:
# Input: a = "ulacfd", b = "jizalu"
# Output: true
# Explaination: Split them at index 3:
# aprefix = "ula", asuffix = "cfd"
# bprefix = "jiz", bsuffix = "alu"
# Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
# '''
def palindromeHelper(s):
    return s == s[::-1]

def ispalindrome(str1, str2):
    for i in range(len(str1) + 1):
        if palindromeHelper(str1[:i] + str2[i:]) or palindromeHelper(str1[:i] + str2[:i]):
            return True
    return False

a, b = input().split()
print(ispalindrome(a, b))
