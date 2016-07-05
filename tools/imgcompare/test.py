import subprocess

def _compare_main(filepath1, filepath2, scale):
    args = ["java",
          "-jar",
          "ImgCompare.jar",
          r"images\input\test.png",
          r"images\reference\test.png",
          "0.8"]
    args[3] = filepath1
    args[4] = filepath2
    args[5] = scale
    result = subprocess.check_output(args)
    return result

def compare_function(filepath1, filepath2):
    scale_list=[0.8,0.9,0.95,0.99,0.995,0.999]
    for scale in scale_list:
        result= _compare_main(filepath1, filepath2, str(scale))
        index=scale_list.index(scale)
        if result=="DISMATCH":
            if index==0:
                return "Match rate is lower than %s" % (str(scale*100)+"%")
            else:
                return "Match rate is %s" % (str(scale_list[index-1]*100)+"%")
        elif result=="MATCH":
            if index== len(scale_list)-1:
                return "Match rate is %s" % (str(scale_list[index]*100)+"%")
        else:
            return "Compare error!!"
        
if __name__ == '__main__':
    filepath1=r"images\input\test5.png"
    filepath2=r"images\reference\test5.png"
    print compare_function(filepath1,filepath2)
