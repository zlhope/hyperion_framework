import Image  
class gifdraw: 
    def __init__(self, open_file, save_file): 
        self.img = Image.open(open_file) 
        self.save_file = save_file 
    
    def Draw_Something(self,text): 
        import ImageDraw,ImageFont
        try:
            draw = ImageDraw.Draw(self.img) 
            width,height = self.img.size
            ttFont = ImageFont.truetype ("arial.ttf", 100)
            draw.text ((width-600, height-300), text, fill=(255,0,0), font=ttFont)
            self.img.save(self.save_file)
        except:
            print "Draw image load file failed!" 
    
if __name__ == "__main__": 
    file_name = r"D:\test.png"
    save_file = r"D:\save.png"
    oimg = gifdraw(file_name, save_file) 
    oimg.Draw_Something("hehe") 
