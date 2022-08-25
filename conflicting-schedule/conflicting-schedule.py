def string_bits(a_byte):
  return "{:08b}".format(a_byte)

def ones_in_byte(testbyte):
  bits = string_bits(testbyte)
  ones = 0
  for i in range(len(bits)):
    if bits[i] == '1':
      ones += 1
  return ones

# testschedule for Matthias m
m = bytearray()
for i in range(256):
  if ones_in_byte(i) == 5:
    m.append(i)

print(f"We have now {len(m)} schedules with 5 blocks in our list.\n")

print("Unfortunately this includes schedules with 4 blocks on 1 day!")
n = bytearray()
for i in range(len(m)):
  if (m[i] & 0x0f == 0x0f) or (m[i] & 0xf0 == 0xf0):
    print("You would teach all blocks on one day: {:08b}".format(m[i]))
  else:
    n.append(m[i])

print(f"\nWe have now {len(n)} schedules with 5 blocks in our list.\n")
m = n

s = m[random.randint(0, len(m)-1)]
print(f"Let's pick this random one and compare to the set of {len(m)}: " + string_bits(s) + "\n")

planning0 = 0
planning1 = 0
planning2 = 0
planning3 = 0

for i in range(0, len(m), 4):
  ausgabe = ""
  for j in range(4):
    overlap = m[i+j] | s
    x = ones_in_byte(overlap)
    if x == 8:
      planning0 += 1
    elif x == 7:
      planning1 += 1
    elif x == 6:
      planning2 += 1
    else:
      planning3 += 1
    ausgabe += string_bits(overlap or 0xff) + " "
    ausgabe += str(x) + "  "
  print(ausgabe)

print("\nStatistically of the 48 options we have:")
print(f"Zero planning blocks:  {planning0} or {int(planning0/0.48)} percent.")
print(f"One planning blocks:  {planning1} or {int(planning1/0.48)} percent.")
print(f"Two planning blocks:  {planning2} or {int(planning2/0.48)} percent.")
print(f"Three planning blocks: {planning3} or  {int(planning3/0.48)} percent.")
