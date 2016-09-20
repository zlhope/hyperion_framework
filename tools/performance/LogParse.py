import xlrd
from xlrd import open_workbook
from xlutils.copy import copy
import sys
def getPerformance(source,string):
    
    with open(source) as f:
        for line in f:
            if string in line:
                return line.split(':')[-1].replace('ms','')
               
    return 'X'


if __name__ == "__main__":
    source = 'C:/02_Telanav/1_Workspace/Scout4cars/performance/automaticLog.log'
    dest = 'C:/02_Telanav/1_Workspace/Scout4cars/performance/Performance.xls'
    offboard = 'true'
    if len(sys.argv) == 2:
        dest = sys.argv[1]
    elif len(sys.argv) > 2:
        source = sys.argv[1]
        dest = sys.argv[2]
        offboard = sys.argv[3]
        
    rb = open_workbook(dest, formatting_info=True)
    rs = rb.sheet_by_index(0)
    wb = copy(rb)
    ws = wb.get_sheet(0)
    tempType =''

    if offboard=='true':
        index = 4
        print("offboard index: ", index)
    else:
        index = 5
        print("onboard index: ", index)
    
    for row in range(2,rs.nrows):
        caseid = rs.cell_value(row,2)
        casetype = rs.cell_value(row,0)
        if casetype !='':
            tempType = casetype
            
        string = str(caseid) + ' ' + str(tempType)
        print('case: ',string)
        
        perfTime = getPerformance(source,string)
        ws.write(row,index,perfTime) 
    wb.save(dest)
        
