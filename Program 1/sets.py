def set_new() :
    """Return a new set"""
    return []

def set_remove(s, value):
    """Remove the given value from the set s"""
    if type(s)!=type([]) :
        raise ValueError
    s.remove(value)
    for item in s:
        if item == value:
            s.remove(value)
    return s

def set_union(s1, s2) :
    """Return the union of sets s1 and s2 as a list"""
    if type(s1)!=type([]) or type(s2)!=type([]):
        raise ValueError
    tempSet = set_intersection(s1,s2)
    s3 = s1 + s2
    finalList = []
    trashList = []
    for x in s3:
        if x not in finalList:
            finalList.append(x)
        else:
            trashList.append(x)
    return finalList

def set_intersection(s1, s2) :
    """Return the intersection of sets s1 and s2 as a list"""
    if type(s1)!=type([]) or type(s2)!=type([]):
        raise ValueError
    tempSet = [value for value in s1 if value in s2]
    trashList = []
    finalList = []
    for x in tempSet:
        if x not in finalList:
            finalList.append(x)
        else:
            trashList.append(x)

    return finalList

def set_membership(s, value):
    """Return True if value is in the set s, and False otherwise"""
    if type(s)!=type([]) :
        raise ValueError
    for x in s:
        if x != value:
            continue
        else:
            return 1
    return 0

def set_equals(s1, s2) :
    """Return True if the sets s1 and s2 have exactly the same elements"""
    if type(s1)!=type([]) or type(s2)!=type([]):
        raise ValueError
    if s1 == s2:
        return 1
    else:
        return 0


def set_difference(s1, s2) :
    """Return the set difference of s1 and s2"""
    if type(s1)!=type([]) or type(s2)!=type([]):
        raise ValueError
    if s1 + s2 == []:
        return []
    temp = []
    temp2 = []
    bigger = s1
    smaller = s2
    if len(s1) < len(s2):
        bigger = s2
        smaller = s1
    for x in bigger:
        if x not in smaller:
            temp.append(x)
    for x in temp:
        if x not in temp2:
            temp2.append(x)
    temp2.sort()
    return temp2

def is_subset(s1, s2) :
    """Return True if s1 is a subset of s2"""
    if type(s1)!=type([]) or type(s2)!=type([]):
        raise ValueError
    emptyList = []
    counter = 0
    if s1 == emptyList:
        return 1
    elif len(s1) > len(s2):
        return 0
    elif s1 == s2:
        return 1
    for x in s1:
        if (x == x in s2):
            counter = counter + 1
        if counter <= len(s2) and counter == len(s1):
            return 1
    return 0

def is_proper_subset(s1, s2) :
    """Return True if s1 is a proper subset of s2"""
    if type(s1)!=type([]) or type(s2)!=type([]):
        raise ValueError
    emptyList = []
    counter = 0
    if s1 == emptyList:
        return 1
    elif len(s1) > len(s2):
        return 0
    elif s1 == s2:
        return 0
    for x in s1:
        if (x == x in s2):
            counter = counter + 1
        if counter <= len(s2) and counter == len(s1):
            return 1
    return 0

set1 = [4, 8, 14, 10, 16, 18, 8]
set2 = [4, 9 , 12, 22, 18, 8, 1]
set3 = set_union(set1, set2)
print(set3)
print(set_intersection(set1, set2))
print(set_membership(set1, 1))
print(set_equals(set1,set1))
print(set_difference(set1, set2))
print(is_subset(set1, set2))
print(is_proper_subset(set1,set2))