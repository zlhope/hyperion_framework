from images2gif import writeGif
from PIL import Image
import traceback
import os
PATH="..\\app\\build\\gif_output\\"
def create_gif_file():
    dir_list=os.listdir(PATH)
    for dir in dir_list:
        file_names = sorted(
            (fn for fn in os.listdir(PATH+dir) if fn.endswith('.png'))
            )
        try:
            images = [Image.open(PATH+dir+"\\"+fn) for fn in file_names]
        except:
            print "Load image failed!"
            continue
        #draw_gif(images[0].filename,"Begin")
        #draw_gif(images[-1].filename,"End")
        size = (1000,1000)
        for im in images:
            try:
                im.thumbnail(size, Image.ANTIALIAS)
            except:
                images.pop(images.index(im))
        filename = PATH+dir+"\\"+dir+".gif"
        try:
            writeGif(filename, images, duration=0.6)
        except:
            print "Write gif file failed!"
            traceback.print_exc()
    copy_gif_file()
               
def copy_gif_file():
    os.system(r"mkdir ..\app\build\reports\androidTests\connected\gif")
    dir_list=os.listdir(PATH)
    for dir in dir_list:
        file_names = sorted(
            (fn for fn in os.listdir(PATH+dir) if fn.endswith('.gif'))
            )
        if len(file_names)!=0:
            source_gif_file=PATH+dir+"\\"+file_names[0]
            targt_location="..\\app\\build\\reports\\androidTests\\connected\\gif"+"\\"+file_names[0]
            print r"copy "+source_gif_file+" "+ targt_location +" /y"
            os.system(r"copy "+source_gif_file+" "+ targt_location +" /y")
            
def draw_gif(file_name, text):
    try:
        from gifdraw import gifdraw
        print file_name
        oimg = gifdraw(file_name, file_name) 
        oimg.Draw_Something(text) 
    except:
        print "Image draw failed!"

if __name__ == "__main__": 
    create_gif_file()