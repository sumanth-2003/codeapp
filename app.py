from flask import Flask, render_template, send_from_directory
import os

app = Flask(__name__)

@app.route('/')
def index():
    problems = {}
    problem_dir = 'problems'
    for filename in os.listdir(problem_dir):
        if filename.endswith('.java'):
            with open(os.path.join(problem_dir, filename), 'r') as file:
                lines = file.readlines()
                tags = [line.strip().replace('//tags: ', '').replace(' ',' - ') for line in lines if line.startswith('//tags:')]
                problems[filename] = tags
    return render_template('index.html', problems=problems)

@app.route('/problems/<path:filename>')
def download_file(filename):
    return send_from_directory('problems', filename)

if __name__ == '__main__':
    app.run(debug=True)
