#see https://github.com/python/cpython/blob/master/Lib/hashlib.py
#for implementation of sha256

import hashlib
import datetime
import binascii
start = datetime.datetime.now()

for i in range(1000000):
    m = hashlib.sha256()
    m.update(b"aaaaaaaaaa")
    x = (binascii.hexlify(m.digest()))
    #print(x)

end = datetime.datetime.now()
diff = end - start
print(str(diff.microseconds) + "[µs]")
