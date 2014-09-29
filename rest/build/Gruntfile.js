module.exports = function (grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        watch: {
            html: {
                files: ['../src/main/webapp/app/**/*.html'],
                options: {
                    spawn: false,
                    livereload: true
                }
            },
            css: {
                files: ['src/main/webapp/css/*.css'],
                options: {
                    spawn: false,
                    livereload: true
                }
            },
            js: {
                files: ['../src/main/webapp/app/**/*.js'],
                options: {
                    spawn: false,
                    livereload: true
                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.registerTask('default', [])
};

