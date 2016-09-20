import os
import logging
import shutil
import tarfile
import zipfile
import subprocess
import stat
import hashlib
import datetime
import csv
import codecs


def log_configuration(log_level):
    logging.basicConfig(format='%(levelname)s %(filename)s %(asctime)s %(funcName)s %(lineno)s:%(message)s', level=log_level)


def execute_sys_command(command):
    logging.debug('Command is: ' + command)

    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    output = process.stdout.readlines()
    for line in output:
        logging.debug(line)
    retval = process.wait()

    return ''.join(tuple(output))


def execute_real_time_command(command):
    logging.debug('Command is: ' + command)

    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    log = ''
    while True:
        output = process.stdout.readline()
        if output == '' and process.poll() is not None:
            break
        if output:
            logging.debug(output.strip())
            log = log + output

    return log


def touch(file_path):
    logging.debug('Touch file: {0}'.format(file_path))

    basedir = os.path.dirname(file_path)
    mkdirs(basedir)

    with open(file_path, 'a'):
        os.utime(file_path, None)


def rm(path):
    logging.debug('Deleting path: {0}'.format(path))
    os.remove(path) if os.path.exists(path) else None


def rmfile(file_path):
    logging.debug('Deleting file: {0}'.format(file_path))
    os.remove(file_path) if os.path.exists(file_path) else None


def rmdir(directory):
    logging.debug('Remove directory: {0}'.format(directory))
    if os.path.exists(directory):
        shutil.rmtree(directory)


def mkdirs(directory):
    if not os.path.exists(directory):
        logging.debug('Create directory: {0}'.format(directory))
        os.makedirs(directory)


def rm_empty_dir(path):
    for root, dirs, files in os.walk(path, topdown=False):
        for dir_name in dirs:
            directory = os.path.join(root, dir_name)
            if os.path.exists(directory):
                if not os.listdir(directory):
                    logging.debug('Delete empty directory: {0}'.format(directory))
                    os.removedirs(directory)


def move(from_file, to_file):
    logging.debug('Move file from: {0} to: {1}'.format(from_file, to_file))
    shutil.move(from_file, to_file)


def copyfile(from_file, to_file):
    logging.debug('Copy file from: {0} to: {1}'.format(from_file, to_file))

    if os.path.realpath(from_file) == os.path.realpath(to_file):
        logging.info('Skipping copy because {0} {1} are the same file.'.format(from_file, to_file))
    else:
        mkdirs(os.path.dirname(to_file))
        shutil.copyfile(from_file, to_file)


def copytree(src, dst, symlinks=False, ignore=None):
    logging.debug('Copy tree from: {0} to: {1}'.format(src, dst))
    if not os.path.exists(dst):
        os.makedirs(dst)
        shutil.copystat(src, dst)
    lst = os.listdir(src)
    if ignore:
        excl = ignore(src, lst)
        lst = [x for x in lst if x not in excl]
    for item in lst:
        s = os.path.join(src, item)
        d = os.path.join(dst, item)
        if symlinks and os.path.islink(s):
            if os.path.lexists(d):
                os.remove(d)
            os.symlink(os.readlink(s), d)
            try:
                st = os.lstat(s)
                mode = stat.S_IMODE(st.st_mode)
                os.lchmod(d, mode)
            except:
                pass  # lchmod not available
        elif os.path.isdir(s):
            copytree(s, d, symlinks, ignore)
        else:
            shutil.copy2(s, d)


def untar(file, dist):
    logging.info('untar file: {0} to directory: {1}'.format(file, dist))
    if os.path.isfile(file):
        tar = tarfile.open(file)
        for member in tar.getmembers():
            if member.isreg():
                # is file
                if member.name.startswith('/'):
                    logging.error('Input tar file have leading /, try handle bad data.')

                    fixed_member_name = member.name[1:]

                    logging.info('Fix name from: {0} to: {1}'.format(member.name, fixed_member_name))

                    # Removing leading `/' from member names
                    member.name = fixed_member_name

                logging.debug('Unpacking: {0}'.format(member.name))
                tar.extract(member, dist)
        tar.close()
    else:
        logging.error('Tar file not exist {0}'.format(file))


def unzip(file, dist):
    logging.info('unzip file: {0} to directory: {1}'.format(file, dist))
    if os.path.isfile(file):
        zip = zipfile.ZipFile(file, 'r')
        zip.extractall(path=dist)
        zip.close()
    else:
        logging.error('Zip file not exist: {0}'.format(file))


def write_text_to_file(filename, text):
    text_file = open(filename, 'ab')
    text_file.writelines(text)
    text_file.close()

    return text


def save_to_csv_file(csv_file, csv_data):
    dir_name = os.path.dirname(csv_file)
    mkdirs(dir_name)
    with codecs.open(csv_file, 'a', 'utf-8') as file:
        writer = csv.writer(file, dialect='excel', lineterminator='\n')
        for row in csv_data:
            writer.writerow(row)


def get_execute_dir():
    execute_dir = os.path.dirname(os.path.realpath(__file__))

    logging.debug('The dir for execute .py is: {0}'.format(execute_dir))
    return execute_dir


def generate_time_stamp():
    time_stamp = datetime.datetime.now().strftime('%Y%m%d%H%M%S')

    logging.debug('Time stamp is: {0}'.format(time_stamp))
    return time_stamp


def create_tarfile(source_directory, output_filename):
    logging.debug('Creating tar package: {0} from directory: {1}'.format(output_filename, source_directory))

    with tarfile.open(output_filename, 'w:gz') as tar:
        tar.add(source_directory, arcname=os.path.basename(source_directory))
    return output_filename


def md5sum(file_path):
    hash = hashlib.md5()
    with open(file_path, 'rb') as file_handler:
        for chunk in iter(lambda: file_handler.read(4096), b""):
            hash.update(chunk)
    sum = hash.hexdigest()
    logging.debug('File: {0} md5sum is: {1}'.format(file_path, sum))
    return sum


def generate_md5_manifest(directory, manifest_file_path):
    logging.debug('Generate MD5 manifest file: {0} for directory: {1}'.format(manifest_file_path, directory))
    rm(manifest_file_path)

    separate_char = '  '
    manifest_dict = dict()
    for root, dirs, files in os.walk(directory):
        for filename in files:
            if filename != os.path.basename(manifest_file_path):
                hash = md5sum(os.path.join(root, filename))

                relative_path = os.path.abspath(os.path.join(root, filename)).replace(os.path.abspath(directory), '')
                text = hash + separate_char + relative_path.strip(os.path.sep) + '\n'
                text = text.replace(os.path.sep, '/')
                logging.debug('{0}'.format(text))

                manifest_dict[text.split(separate_char)[1]] = text

    items = manifest_dict.items()
    items.sort()
    for key, value in items:
        write_text_to_file(manifest_file_path, value)


def compare_file_binary(file1, file2):
    logging.debug('Comparing binary between: {0} and {1}'.format(file1, file2))

    md5_file1 = md5sum(file1)
    md5_file2 = md5sum(file2)

    result = (md5_file1 == md5_file2)
    if result:
        logging.debug('Files are identical: {0} and {1}, MD5 is: {2}'.format(file1, file2, md5_file1))
    else:
        logging.debug('Files are different. {0} MD5 is: {1} but {2} MD5 is: {3}'.format(file1, md5_file1, file2, md5_file2))
    return result


def human_readable_size(file_path):
    return sizeof(os.path.getsize(file_path))


def sizeof(num, suffix='B'):
    for unit in ['', 'Ki', 'Mi', 'Gi', 'Ti', 'Pi', 'Ei', 'Zi']:
        if abs(num) < 1024.0:
            return '%3.1f%s%s' % (num, unit, suffix)
        num /= 1024.0
    return '%.1f%s%s' % (num, 'Yi', suffix)


def endswith_set(text, set_object):
    result = False
    if len(set_object) == 0:
        # always True for empty set
        return True

    for obj in set_object:
        if text.endswith(obj):
            result = True
            break

    return result
