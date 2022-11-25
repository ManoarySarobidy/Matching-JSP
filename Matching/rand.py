from random import *
# from Numpy import *

group = []

while len(group) <= 6 :
	a = randint(1,6)
	b = randint(7,12)
	if a != b :
		sub = []
		sub.append(a)
		sub.append(b)
		sub.sort()
		for i in range( len(group) ):
			er = group[i]
			er.sort()
			if( sub != er ):
				group.append(sub)
		if (len(group)==0):
			group.append(sub)		

print( group )